package Com.Java.AccountingSystem.ModelClassPackage.Numfor.Elmer.Chenemo;

public class SalesChartModel {

    private Double Totalamount;
    private String Date;

    public SalesChartModel(Double Totalamount, String Date) {
        this.Totalamount = Totalamount;
        this.Date = Date;
    }

    public Double getTotalamount() {
        return Totalamount;
    }

    public void setTotalamount(Double Totalamount) {
        this.Totalamount = Totalamount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

}
