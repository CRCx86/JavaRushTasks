package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

/**
 * Created by a.zinov on 25.05.2017.
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    private void setBorderColor(Shape shape) {
        System.out.println("Setting border color for " + shape.getClass().getSimpleName() + " to red.");
    }

    @Override
    public void draw() {
        setBorderColor(this.decoratedShape);
        super.draw();
    }
}
