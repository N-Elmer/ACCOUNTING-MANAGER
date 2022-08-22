package Com.Java.AccountingSystem.ModelClassPackage.Numfor.Elmer.Chenemo;

public class SalesModel {

    private String Id;
    private String Customername;
    private String Phonenumber;
    private String Cardescription;
    private String Quantity;
    private String Totalamount;
    private String Date;

    public SalesModel(String Id, String Customername, String Phonenumber, String Cardescription, String Quantity, String Totalamount, String Date) {
        this.Id = Id;
        this.Customername = Customername;
        this.Phonenumber = Phonenumber;
        this.Cardescription = Cardescription;
        this.Quantity = Quantity;
        this.Totalamount = Totalamount;
        this.Date = Date;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String Customername) {
        this.Customername = Customername;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String Phonenumber) {
        this.Phonenumber = Phonenumber;
    }

    public String getCardescription() {
        return Cardescription;
    }

    public void setCardescription(String Cardescription) {
        this.Cardescription = Cardescription;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getTotalamount() {
        return Totalamount;
    }

    public void setTotalamount(String Totalamount) {
        this.Totalamount = Totalamount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

}
