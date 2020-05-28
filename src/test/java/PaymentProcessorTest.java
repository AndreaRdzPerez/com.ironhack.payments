import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {

    private Account seller;
    private static Account buyer;
    private static PaymentProcessor payment;

    @BeforeEach
    public void setUp() {
        buyer = new Account("Pepe", 300);
        seller = new Account("Juana", 400);
        payment = new PaymentProcessor();
    }

    @Test
    public void processTaxExemptPurchase_NormalPurchaseWorks() throws Exception {
        payment.ProcessTaxExemptPurchase(seller, buyer, 50);
        assertEquals(250, buyer.getBalance());
        assertEquals(450, seller.getBalance());
    }

    @Test
    public void processTaxExemptPurchase_NegativePurchaseGetError() throws Exception {
        assertThrows(Exception.class, () -> payment.ProcessTaxExemptPurchase(seller, buyer, 500));
    }

    @Test
    public void processTaxedPurchase_NormalPurchaseWorks() throws Exception {
        payment.processTaxedPurchase(seller, buyer, 50);
        assertEquals(243, buyer.getBalance());
        assertEquals(457, seller.getBalance());
    }

    @Test
    public void issueRefund_NormalPurchaseWorks() throws Exception {
        payment.issueRefund(seller, buyer, 50, 1.30);
        assertEquals(365, buyer.getBalance());
    }
}