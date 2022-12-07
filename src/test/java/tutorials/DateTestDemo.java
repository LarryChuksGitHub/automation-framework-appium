package tutorials;


import org.assertj.jodatime.api.Assertions;
import org.joda.time.LocalDate;
import org.testng.annotations.Test;

public class DateTestDemo {


    @Test
    public void testDate(){
        LocalDate localDate = new LocalDate(2020,10,01);
        Assertions.assertThat(localDate)
                .hasYear(2020)
                .hasMonthOfYear(10)
                .hasDayOfMonth(01)
                .isAfter("2020-09-30")
                .isNotNull()
                .isNotIn("2030-01-10")
                .isIn(new LocalDate(2021,01,01), new LocalDate(2020,10,01));
    }
}
