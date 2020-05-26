public class PaymentProcessor {
    private double purchaseAmount;
    private Account buyer;
    private Account seller;
    private double percent;

    public PaymentProcessor(double purchaseAmount, Account buyer, Account seller, double percent) {
        this.purchaseAmount = purchaseAmount;
        this.buyer = buyer;
        this.seller = seller;
        this.percent = percent;
    }

    public PaymentProcessor(double purchaseAmount, Account buyer, Account seller) {
        this.purchaseAmount = purchaseAmount;
        this.buyer = buyer;
        this.seller = seller;
        this.percent = 0;
    }

    public PaymentProcessor() {
        this.purchaseAmount = 0.0;
        this.buyer = null;
        this.seller = null;
        this.percent = 0;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double puchaseAmount) {
        this.purchaseAmount = puchaseAmount;
    }

    public Account getBuyer() {
        return buyer;
    }

    public void setBuyer(Account buyer) {
        this.buyer = buyer;
    }

    public Account getSeller() {
        return seller;
    }

    public void setSeller(Account seller) {
        this.seller = seller;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void ProcessTaxExemptPurchase (Account seller, Account buyer, double PurchaseAmount) throws Exception{
        if (buyer.getBalance() > PurchaseAmount){
        buyer.setBalance((int) (buyer.getBalance()- PurchaseAmount));
        seller.setBalance((int) (seller.getBalance() + PurchaseAmount));
        }else {
        throw new Exception ("Not enough money");
        }
        }

    public void processTaxedPurchase(Account seller, Account buyer, double PurchaseAmount) throws Exception {
        double tax = 1.14;
        if (buyer.getBalance() > PurchaseAmount){
            buyer.setBalance((int) (buyer.getBalance()- (PurchaseAmount * tax)));
            seller.setBalance((int) (seller.getBalance() + (PurchaseAmount * tax)));
        }else {
            throw new Exception ("Not enough money");
        }
    }

    public void issueRefund(Account seller, Account buyer, double PurchaseAmount, double percent) throws Exception {
        if (buyer.getBalance() > PurchaseAmount){
            buyer.setBalance((int) (buyer.getBalance()+ (PurchaseAmount * percent)));
            seller.setBalance((int) (seller.getBalance() - (PurchaseAmount * percent)));
        }else {
            throw new Exception ("No cash left for return");
        }
    }
    }

