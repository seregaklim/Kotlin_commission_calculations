import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
   fun  transferVkPay() {
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
    fun  notTransferVkPay() {
        //arrange

        val maxTransferText = "Максимальная сумма переводов"
        val convectorRubleToKopeck = 100
        var transferKopeckVkPay = 40001 * convectorRubleToKopeck
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
    fun whenTransferKopeckVkPay () {


    }
}