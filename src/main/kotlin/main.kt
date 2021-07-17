
fun main() {
    val transferVkPay = "перевод Vk Pay"
    val transferMastercardMaestro = "перевод Mastercard Maestro"
    val transferVisaAndMir = "перевод Visa и Mир"
    val maxTransferText = "Максимальная сумма переводов"

    val convectorRubleToKopeck = 100
    
    val transferLimitMonth = 600_000 * convectorRubleToKopeck
    val transferLimitDate = 150000 * convectorRubleToKopeck

    val minTransferRublesVisaMir = 35 * convectorRubleToKopeck
    val commissionVisaMir = 0.75 / 100
    val transferVisaMir = 207787 * convectorRubleToKopeck
    var maxSummaTransferVisaMir = 0 * convectorRubleToKopeck

    val resultVisaMir = resultVisaMir(
        maxTransferText,
        transferLimitMonth,
        maxSummaTransferVisaMir,
        transferVisaMir,
        minTransferRublesVisaMir,
        transferLimitDate,
        commissionVisaMir.toInt()
    )

    val maxSummaTransferMastercardMaestro = 0 * convectorRubleToKopeck
    val transfermastercardMaestroKopecks = 60000 * convectorRubleToKopeck
    val discounttransferMastercardMaestroKopeks: Int = 75_000 * convectorRubleToKopeck
    val disountMastercardMaestro = true
    val commissionMastercardMaestro: Int = (transfermastercardMaestroKopecks * 0.6 / 100 + 2000).toInt()

    val resultMastercardMaestro = resultMastercardMaestro(
        disountMastercardMaestro,
        maxSummaTransferMastercardMaestro,
        transferLimitMonth,
        transfermastercardMaestroKopecks,
        transferLimitDate,
        commissionMastercardMaestro,
        maxTransferText,
        discounttransferMastercardMaestroKopeks
    )
    val transferKopeckVkPay = 4000 * convectorRubleToKopeck
    val minTransferVkPay = 15000 * convectorRubleToKopeck
    var maxSummaTransferVkPay = 0
    val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck


    val transfer = transfer( maxTransferText,
        transferKopeckVkPay,
        minTransferVkPay,
        maxSummaTransferVkPay,
        maxTransferVkPayMoth,
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
        commissionVisaMir.toInt())

    println("Перевод сотавил $transfer копеек")
}
fun transfer(
    maxTransferText: String,
    transferKopeckVkPay: Int,
    minTransferVkPay: Int,
    maxSummaTransferVkPay: Int,
    maxTransferVkPayMoth: Int,
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
    commissionVisaMir: Int
) = when ("перевод Vk Pay") {
    "перевод Vk Pay" -> {
        transferVkPay( maxTransferText,
            transferKopeckVkPay,
            minTransferVkPay,
            maxSummaTransferVkPay,
            maxTransferVkPayMoth)
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
    "перевод Visa и Mир" -> {
        resultVisaMir(
            maxTransferText,
            transferLimitMonth,
            maxSummaTransferVisaMir,
            transferVisaMir,
            minTransferRublesVisaMir,
            transferLimitDate,
            commissionVisaMir.toInt())
    }
    else -> { "У Вас неизветная платежная система!"
    }
}
fun  transferVkPay(
    maxTransferText: String,
    transferKopeckVkPay: Int,
    minTransferVkPay: Int,
    maxSummaTransferVkPay: Int,
    maxTransferVkPayMoth: Int
) = when {
    transferKopeckVkPay <= minTransferVkPay && maxSummaTransferVkPay <= maxTransferVkPayMoth -> transferKopeckVkPay
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
    !(false || maxSummaTransferMastercardMaestro > transferLimitMonth 
            || maxSummaTransferMastercardMaestro > transferLimitDate 
            || transfermastercardMaestroKopecks > discounttransferMastercardMaestroKopeks)
            && transfermastercardMaestroKopecks <= discounttransferMastercardMaestroKopeks 
    -> transfermastercardMaestroKopecks

    !(maxSummaTransferMastercardMaestro > transferLimitMonth 
            || maxSummaTransferMastercardMaestro > transferLimitDate)
    -> transfermastercardMaestroKopecks * commissionMastercardMaestro

    else -> maxTransferText
}
fun  resultVisaMir(
    maxTransferText: String,
    transferLimitMonth: Int,
    maxSummaTransferVisaMir: Int,
    transferVisaMir: Int,
    minTransferRublesVisaMir: Int,
    transferLimitDate: Int,
    commissionVisaMir: Int
) = when  {

    maxSummaTransferVisaMir <= transferLimitMonth && maxSummaTransferVisaMir <= transferLimitDate
            && transferVisaMir >= minTransferRublesVisaMir && transferVisaMir <= transferLimitDate
    -> transferVisaMir * commissionVisaMir


    maxSummaTransferVisaMir <= transferLimitMonth && maxSummaTransferVisaMir <= transferLimitDate
            && transferVisaMir <= minTransferRublesVisaMir && transferVisaMir <= transferLimitDate
    -> transferVisaMir - minTransferRublesVisaMir
    else -> maxTransferText
}
