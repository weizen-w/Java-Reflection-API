package example03;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 9/4/2023
 * Java Reflection API
 *
 * @author Marsel Sidikov (AIT TR)
 */

public class Bill {

    @DefaultValue(value = "12345")
    private int subscriberNo;

    @DefaultValue(value = "86.7")
    private double sum;

    @DefaultValue(value = "2022-02-13")
    private LocalDate date;

    public Bill() {
    }

    Bill(int subscriberNo, double sum, LocalDate date) {
        this.subscriberNo = subscriberNo;
        this.sum = sum;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "subscriberNo=" + subscriberNo +
                ", sum=" + sum +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill bill)) return false;

        if (subscriberNo != bill.subscriberNo) return false;
        if (Double.compare(bill.sum, sum) != 0) return false;
        return Objects.equals(date, bill.date);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = subscriberNo;
        temp = Double.doubleToLongBits(sum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
