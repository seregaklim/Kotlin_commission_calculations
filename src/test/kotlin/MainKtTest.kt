import org.junit.Test

import org.junit.Assert.*


class MainKtTest {
    @Test
    fun transferVkPay(){

        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 14000 * convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck

        val transfersVkPay = transferVkPay(
            maxTransferText,
            transferKopeckVkPay,
            maxTransferVkPay,)

        assertEquals(1400000,transfersVkPay )
    }

    @Test
    fun notTransferVkPay(){

        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 20000 * convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck

        val transfersVkPay = transferVkPay(
            maxTransferText,
            transferKopeckVkPay,
            maxTransferVkPay,)

        assertEquals(maxTransferText,transfersVkPay )
    }

    @Test
    fun transferVkPayWhen54() {
        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 20000 * convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck

        fun transferVkPayWhen() = when {

            transferKopeckVkPay >= maxTransferVkPay -> maxTransferText
            transferKopeckVkPay <= maxTransferVkPay ->  transferKopeckVkPay
            transferKopeckVkPay <= 0 -> 0
            else -> "ошибка"
        }
        assertEquals(maxTransferText,transferVkPayWhen())

    }
    @Test
    fun transferVkPayWhen() {
        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 0 * convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck
        fun transferVkPayWhen() = when {
            transferKopeckVkPay <= maxTransferVkPay -> transferKopeckVkPay
            transferKopeckVkPay >= maxTransferVkPay -> maxTransferText

            else -> 0
        }
        assertEquals(0,transferVkPayWhen())
    }
    @Test
    fun notTransferVkPayMoth() {
        //arrange
        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 500* convectorRubleToKopeck
        val maxTransferVkPay = 15000 * convectorRubleToKopeck

        //act
        val transfersVkPay = transferVkPay(
            maxTransferText,
            transferKopeckVkPay,
            maxTransferVkPay,
        )
        //assert
        assertEquals(50000, transfersVkPay)
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
        val zero = 0
        val maxTransferVkPayMoth = 40000 * convectorRubleToKopeck


        val maxSummaTransferMastercardMaestro = 0 * convectorRubleToKopeck
        var transfermastercardMaestroKopecks = 50000 * convectorRubleToKopeck
        val discounttransferMastercardMaestroKopeks: Int = 75_000 * convectorRubleToKopeck
        val disountMastercardMaestro = true
        var commissionMastercardMaestro: Int = (transfermastercardMaestroKopecks * 0.006 + 2000).toInt()
        commissionMastercardMaestro = transfermastercardMaestroKopecks - commissionMastercardMaestro
        //act

        val transfer = transfer(
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
            trComVisaMir.toInt(),

        )
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
