package tutorials;

import org.assertj.core.api.Assertions;
import org.testng.Assert;

public class Car {

    private  int number, age;
    private  String owner, color;

    public Car(int number, int age, String owner, String color) {
        this.number = number;
        this.age = age;
        this.owner = owner;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Car car1 = new Car(1,5,"Jon","red");
        Car car2 = new Car(1,5,"Jon","red");
        Assertions.assertThat(car1).isEqualToComparingFieldByField(car2)
                .isInstanceOf(Car.class)
                .hasFieldOrProperty("age").isInstanceOf(Car.class).isNotNull().hasFieldOrPropertyWithValue("color","red")
                .extracting(car-> car.getAge()).isNotEqualTo(2);


       // Assert.assertTrue(car1.equals(car2));
        Assert.assertTrue(car1.getColor().equalsIgnoreCase(car1.getColor()));
        Assert.assertTrue(car1.getAge() == car2.getAge(),"car age is not same " + "car1 age: " + car1.getAge() +" car2 age: " + car2.getAge());
        boolean isAge = false;
        if (car1.getAge() == car1.getAge()){
            isAge = true;
        }
        Assert.assertTrue(isAge,"Cat age is not same");
    }
}
