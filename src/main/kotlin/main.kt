
fun main () {
    val transferVkPay = "перевод Vk Pay"
    val transferMastercardMaestro = "перевод Mastercard Maestro"
    val transferVisaAndMir = "перевод Visa и Mир"
    val maxTransferText = "Максимальная сумма переводов"

    val convectorRubleToKopeck = 100

    val transferLimitMonth = 600_000 * convectorRubleToKopeck
    val transferLimitDate = 150_000 * convectorRubleToKopeck

    val minTransferRublesVisaMir = 35 * convectorRubleToKopeck
    val commissionVisaMir = 0.0075
    var transferVisaMir = 34241 * convectorRubleToKopeck

    var maxSummaTransferVisaMir = 0 * convectorRubleToKopeck
    var trComVisaMir =  transferVisaMir -( transferVisaMir * commissionVisaMir)


    val resultVisaMir = resultVisaMir(
        maxTransferText,
        transferLimitMonth,
        maxSummaTransferVisaMir,
        transferVisaMir,
        minTransferRublesVisaMir,
        transferLimitDate,
        trComVisaMir.toInt()
    )

    val maxSummaTransferMastercardMaestro = 0 * convectorRubleToKopeck
    var transfermastercardMaestroKopecks = 50000 * convectorRubleToKopeck
    val discounttransferMastercardMaestroKopeks: Int = 75_000 * convectorRubleToKopeck
    val disountMastercardMaestro = true
    var commissionMastercardMaestro: Int = (transfermastercardMaestroKopecks * 0.006 + 2000).toInt()
    commissionMastercardMaestro = transfermastercardMaestroKopecks - commissionMastercardMaestro
    val resultMastercardMaestro = resultMastercardMaestro(
        disountMastercardMaestro,
        maxSummaTransferMastercardMaestro,
        transferLimitMonth,
        transfermastercardMaestroKopecks,
        transferLimitDate,
        commissionMastercardMaestro,
        maxTransferText,
        discounttransferMastercardMaestroKopeks)

    var transferKopeckVkPay = 40000 * convectorRubleToKopeck
    val maxTransferVkPay = 15000 * convectorRubleToKopeck

//    val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck

    val transfersVkPay = transferVkPay(
        maxTransferText,
        transferKopeckVkPay,
        maxTransferVkPay, )

    val transfer =  transfer(
        maxTransferText,
        transferKopeckVkPay,
        maxTransferVkPay,
        disountMastercardMaestro,
        maxSummaTransferMastercardMaestro,
        transferLimitMonth,
        transfermastercardMaestroKopecks,
        transferLimitDate,
        commissionMastercardMaestro,
        discounttransferMastercardMaestroKopeks,
        maxSummaTransferVisaMir,
        transferVisaMir,
        minTransferRublesVisaMir,
        trComVisaMir.toInt(),)

    println ("Перевод сотавил $transfer копеек")

}
fun transfer(
    maxTransferText: String,
    transferKopeckVkPay: Int,
    maxTransferVkPay :Int,
    disountMastercardMaestro: Boolean,
    maxSummaTransferMastercardMaestro: Int,
    transferLimitMonth: Int,
    transfermastercardMaestroKopecks: Int,
    transferLimitDate: Int,
    commissionMastercardMaestro: Int,
    discounttransferMastercardMaestroKopeks: Int,
    maxSummaTransferVisaMir: Int,
    transferVisaMir: Int,
    minTransferRublesVisaMir: Int,
    trComVisaMir: Int,

    ) = when  ( "перевод Vk Pay" ) {
    "перевод Vk Pay" -> {
        transferVkPay(
            maxTransferText,
            transferKopeckVkPay, maxTransferVkPay,
        )
    }
    "перевод Mastercard Maestro" -> {
        resultMastercardMaestro(
            disountMastercardMaestro,
            maxSummaTransferMastercardMaestro,
            transferLimitMonth,
            transfermastercardMaestroKopecks,
            transferLimitDate,
            commissionMastercardMaestro,
            maxTransferText,
            discounttransferMastercardMaestroKopeks
        )
    }
    "перевод Visa и Mир" -> resultVisaMir(
        maxTransferText,
        transferLimitMonth,
        maxSummaTransferVisaMir,
        transferVisaMir,
        minTransferRublesVisaMir,
        transferLimitDate,
        trComVisaMir
    )
    else -> { "У Вас неизветная платежная система!"
    }
}

fun  transferVkPay(
    maxTransferText: String,
    transferKopeckVkPay: Int,
    maxSummaTransferVkPay: Int,

) = when {
    transferKopeckVkPay <= maxSummaTransferVkPay
    -> transferKopeckVkPay
    else -> maxTransferText
}

fun resultMastercardMaestro(
    disountMastercardMaestro: Boolean,
    maxSummaTransferMastercardMaestro: Int,
    transferLimitMonth: Int,
    transfermastercardMaestroKopecks: Int,
    transferLimitDate: Int,
    commissionMastercardMaestro: Int,
    maxTransferText: String,
    discounttransferMastercardMaestroKopeks:Int
) = when (disountMastercardMaestro ) {
    disountMastercardMaestro && maxSummaTransferMastercardMaestro <= transferLimitMonth
            && maxSummaTransferMastercardMaestro
            <= transferLimitDate && transfermastercardMaestroKopecks <= discounttransferMastercardMaestroKopeks
            && transfermastercardMaestroKopecks <= transferLimitDate -> transfermastercardMaestroKopecks

    maxSummaTransferMastercardMaestro <= transferLimitMonth
            && maxSummaTransferMastercardMaestro
            <= transferLimitDate && transfermastercardMaestroKopecks >= discounttransferMastercardMaestroKopeks
            && transfermastercardMaestroKopecks <= transferLimitDate
    -> commissionMastercardMaestro

    else -> maxTransferText
}
fun  resultVisaMir(
    maxTransferText: String,
    transferLimitMonth: Int,
    maxSummaTransferVisaMir: Int,
    transferVisaMir: Int,
    minTransferRublesVisaMir: Int,
    transferLimitDate: Int,
    trComVisaMir: Int
) = when  {

    maxSummaTransferVisaMir <= transferLimitMonth && maxSummaTransferVisaMir <= transferLimitDate
            && transferVisaMir >= minTransferRublesVisaMir && transferVisaMir <= transferLimitDate
    ->  trComVisaMir


    maxSummaTransferVisaMir <= transferLimitMonth && maxSummaTransferVisaMir <= transferLimitDate
            && transferVisaMir <= minTransferRublesVisaMir && transferVisaMir <= transferLimitDate
    -> transferVisaMir - minTransferRublesVisaMir
    else -> maxTransferText
}


