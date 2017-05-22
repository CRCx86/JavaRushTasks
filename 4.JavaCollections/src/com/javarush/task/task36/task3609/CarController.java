package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }

    public void speedUp(int seconds) {
        if (model.getSpeed() < model.getMaxSpeed()) {

            setCarSpeed(getCarSpeed() + (int) (3.5 * seconds));

//            int speed = model.getSpeed();
//            speed += (3.5 * seconds);
//            model.setSpeed(speed);
        }
        if (model.getSpeed() > model.getMaxSpeed()) {

            setCarSpeed(getCarMaxSpeed());

            //model.setSpeed(model.getMaxSpeed());
        }
    }

    public void speedDown(int seconds) {
        if (model.getSpeed() > 0) {

            setCarSpeed(getCarSpeed() - (12 * seconds));

//            int speed = model.getSpeed();
//            speed -= (12 * seconds);
//            model.setSpeed(speed);
        }
        if (model.getSpeed() < 0) {
            setCarSpeed(0);
            //model.setSpeed(0);
        }
    }
}