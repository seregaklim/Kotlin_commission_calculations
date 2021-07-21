import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transfer() {
        //arrange
        val transferVkPay = "перевод Vk Pay"
        val transferMastercardMaestro = "перевод Mastercard Maestro"
        val transferVisaAndMir = "перевод Visa и Mир"
        val maxTransferText = "Максимальная сумма переводов"

        val convectorRubleToKopeck = 100

        val transferLimitMonth = 600_000 * convectorRubleToKopeck
        val transferLimitDate = 150_000 * convectorRubleToKopeck

        val minTransferRublesVisaMir = 35 * convectorRubleToKopeck
        val commissionVisaMir = 0.0075


        var transferKopeckVkPay = 10000 * convectorRubleToKopeck
        val minTransferVkPay = 15000 * convectorRubleToKopeck
        var maxSummaTransferVkPay = 15000
        val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck
        var maxSummaTransferVisaMir = 0 * convectorRubleToKopeck

        var maxSummaTransferMastercardMaestro = 0* convectorRubleToKopeck
        var transfermastercardMaestroKopecks = 170000* convectorRubleToKopeck
        val discounttransferMastercardMaestroKopeks: Int = 75_000 * convectorRubleToKopeck
        var disountMastercardMaestro = true
        var commissionMastercardMaestro: Int = (transfermastercardMaestroKopecks * 0.006 + 2000).toInt()
        commissionMastercardMaestro = transfermastercardMaestroKopecks - commissionMastercardMaestro
        var transferVisaMir = 60000 * convectorRubleToKopeck
        var trComVisaMir = transferVisaMir - (transferVisaMir * commissionVisaMir)


        //act
        val transfer = transfer(maxTransferText,
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
            trComVisaMir.toInt()
        )

        //assert
        assertEquals(maxTransferText , transfer)
    }
}
//    @Test
//    fun notTransfer() {
//
//        //arrange
//        val transferVkPay = "перевод Vk Pay"
//        val transferMastercardMaestro = "перевод Mastercard Maestro"
//        val transferVisaAndMir = "перевод Visa и Mир"
//        val maxTransferText = "Максимальная сумма переводов"
//
//        val convectorRubleToKopeck = 100
//
//        val transferLimitMonth = 600_000 * convectorRubleToKopeck
//        val transferLimitDate = 150_000 * convectorRubleToKopeck
//
//        val minTransferRublesVisaMir = 35 * convectorRubleToKopeck
//        val commissionVisaMir = 0.0075
//
//
//        val transferKopeckVkPay = 244000 * convectorRubleToKopeck
//        val minTransferVkPay = 15000 * convectorRubleToKopeck
//        var maxSummaTransferVkPay = 0
//        val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck
//        var maxSummaTransferVisaMir = 40 * convectorRubleToKopeck
//
//
//        val maxSummaTransferMastercardMaestro = 0* convectorRubleToKopeck
//        val transfermastercardMaestroKopecks = 200 * convectorRubleToKopeck
//        val discounttransferMastercardMaestroKopeks: Int = 75_000 * convectorRubleToKopeck
//        val disountMastercardMaestro = true
//        var commissionMastercardMaestro: Int = (transfermastercardMaestroKopecks * 0.006 + 2000).toInt()
//        commissionMastercardMaestro = transfermastercardMaestroKopecks - commissionMastercardMaestro
//
//
//        val transferVisaMir = 0 * convectorRubleToKopeck
//        var trComVisaMir = transferVisaMir - (transferVisaMir * commissionVisaMir)
//
//
//        //act
//        val transfer = transfer(maxTransferText,
//            transferKopeckVkPay,
//            minTransferVkPay,
//            maxSummaTransferVkPay,
//            maxTransferVkPayMoth,
//            disountMastercardMaestro,
//            maxSummaTransferMastercardMaestro,
//            transferLimitMonth,
//            transfermastercardMaestroKopecks,
//            transferLimitDate,
//            commissionMastercardMaestro,
//            discounttransferMastercardMaestroKopeks,
//            maxSummaTransferVisaMir,
//            transferVisaMir,
//            minTransferRublesVisaMir,
//            trComVisaMir.toInt()
//        )
//
//        //assert
//        assertEquals( maxTransferText, transfer)
//    }
