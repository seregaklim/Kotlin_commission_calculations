import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transferVkPay() {
        //arrange
        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 10000 * convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck

        val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck
        //act
        val transfersVkPay = transferVkPay(
            maxTransferText,
            transferKopeckVkPay,
            maxTransferVkPay,
            maxTransferVkPayMoth
        )
        //assert
        assertEquals(1000000, transfersVkPay)
    }
    @Test
    fun transferVkPay0() {
        //arrange
        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 0 * convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck

        val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck
        //act
        val transfersVkPay = transferVkPay(
            maxTransferText,
            transferKopeckVkPay,
            maxTransferVkPay,
            maxTransferVkPayMoth
        )
        //assert
        assertEquals(0, transfersVkPay)
    }
    @Test
    fun notTransferVkPay() {
        //arrange

        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 40000 * convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck

        val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck

        //act
        val transfersVkPay = transferVkPay(
            maxTransferText,
            transferKopeckVkPay,
            maxTransferVkPay,
            maxTransferVkPayMoth
        )
        //assert
        assertEquals(maxTransferText, transfersVkPay)

    }

    @Test
    fun notTransferVkPayMoth() {
        //arrange
        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 25000 * convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck

        val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck
        //act
        val transfersVkPay = transferVkPay(
            maxTransferText,
            transferKopeckVkPay,
            maxTransferVkPay,
            maxTransferVkPayMoth
        )
        //assert
        assertEquals(maxTransferText, transfersVkPay)
    }

    @Test
    fun transfer() {
        //arrange

        val maxTransferText = "Максимальная сумма переводов"

        val convectorRubleToKopeck = 100

        val transferLimitMonth = 600_000 * convectorRubleToKopeck
        val transferLimitDate = 150_000 * convectorRubleToKopeck

        val minTransferRublesVisaMir = 35 * convectorRubleToKopeck
        val commissionVisaMir = 0.0075
        var transferVisaMir = 34241 * convectorRubleToKopeck

        var maxSummaTransferVisaMir = 0 * convectorRubleToKopeck
        var trComVisaMir = transferVisaMir - (transferVisaMir * commissionVisaMir)


        var transferKopeckVkPay = 100 * convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck

        val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck


        val maxSummaTransferMastercardMaestro = 0 * convectorRubleToKopeck
        var transfermastercardMaestroKopecks = 50000 * convectorRubleToKopeck
        val discounttransferMastercardMaestroKopeks: Int = 75_000 * convectorRubleToKopeck
        val disountMastercardMaestro = true
        var commissionMastercardMaestro: Int = (transfermastercardMaestroKopecks * 0.006 + 2000).toInt()
        commissionMastercardMaestro = transfermastercardMaestroKopecks - commissionMastercardMaestro
        //act

        val transfer = transfer(maxTransferText,
            transferKopeckVkPay,
            maxTransferVkPay,
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
            trComVisaMir.toInt())
        assertEquals(10000, transfer)

    }

    @Test
    fun resultVisaMir() {
        val transferVkPay = "перевод Vk Pay"
        val transferMastercardMaestro = "перевод Mastercard Maestro"
        val transferVisaAndMir = "перевод Visa и Mир"
        val maxTransferText = "Максимальная сумма переводов"

        val convectorRubleToKopeck = 100

        val transferLimitMonth = 600_000 * convectorRubleToKopeck
        val transferLimitDate = 150_000 * convectorRubleToKopeck

        val minTransferRublesVisaMir = 35 * convectorRubleToKopeck
        val commissionVisaMir = 0.0075
        var transferVisaMir = 80000 * convectorRubleToKopeck

        var maxSummaTransferVisaMir = 0 * convectorRubleToKopeck
        var trComVisaMir = transferVisaMir - (transferVisaMir * commissionVisaMir)


        val resultVisaMir = resultVisaMir(
            maxTransferText,
            transferLimitMonth,
            maxSummaTransferVisaMir,
            transferVisaMir,
            minTransferRublesVisaMir,
            transferLimitDate,
            trComVisaMir.toInt()
        )
        assertEquals(7940000, resultVisaMir)


    }

    @Test
    fun notResultVisaMir() {
        val transferVkPay = "перевод Vk Pay"
        val transferMastercardMaestro = "перевод Mastercard Maestro"
        val transferVisaAndMir = "перевод Visa и Mир"
        val maxTransferText = "Максимальная сумма переводов"

        val convectorRubleToKopeck = 100

        val transferLimitMonth = 600_000 * convectorRubleToKopeck
        val transferLimitDate = 150_000 * convectorRubleToKopeck

        val minTransferRublesVisaMir = 35 * convectorRubleToKopeck
        val commissionVisaMir = 0.0075
        var transferVisaMir = 151000 * convectorRubleToKopeck

        var maxSummaTransferVisaMir = 0 * convectorRubleToKopeck
        var trComVisaMir = transferVisaMir - (transferVisaMir * commissionVisaMir)


        val resultVisaMir = resultVisaMir(
            maxTransferText,
            transferLimitMonth,
            maxSummaTransferVisaMir,
            transferVisaMir,
            minTransferRublesVisaMir,
            transferLimitDate,
            trComVisaMir.toInt()
        )
        assertEquals(maxTransferText, resultVisaMir)
    }
        @Test
        fun resultMastercardMaestro() {
            val convectorRubleToKopeck = 100
            val maxSummaTransferMastercardMaestro = 0 * convectorRubleToKopeck
            var transfermastercardMaestroKopecks = 12000 * convectorRubleToKopeck
            val discounttransferMastercardMaestroKopeks: Int = 75_000 * convectorRubleToKopeck
            val disountMastercardMaestro = true
            var commissionMastercardMaestro: Int = (transfermastercardMaestroKopecks * 0.006 + 2000).toInt()
            commissionMastercardMaestro = transfermastercardMaestroKopecks - commissionMastercardMaestro
            val transferLimitMonth = 600_000 * convectorRubleToKopeck
            val transferLimitDate = 150_000 * convectorRubleToKopeck
            val maxTransferText = "Максимальная сумма переводов"

            val resultMastercardMaestro = resultMastercardMaestro(
                disountMastercardMaestro,
                maxSummaTransferMastercardMaestro,
                transferLimitMonth,
                transfermastercardMaestroKopecks,
                transferLimitDate,
                commissionMastercardMaestro,
                maxTransferText,
                discounttransferMastercardMaestroKopeks)

            assertEquals(1200000, resultMastercardMaestro)

        }
    }
