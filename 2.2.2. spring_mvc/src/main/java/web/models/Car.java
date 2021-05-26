package web.models;

public class Car {
    private String carProducer;
    private String carModel;
    private String carColor;

    public Car(){}

    public Car(String carProducer, String carModel, String carColor) {
        this.carProducer = carProducer;
        this.carModel = carModel;
        this.carColor = carColor;
    }

    public String getCarProducer() {
        return carProducer;
    }

    public void setCarProducer(String carProducer) {
        this.carProducer = carProducer;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carProducer='" + carProducer + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carColor='" + carColor + '\'' +
                '}';
    }
}
