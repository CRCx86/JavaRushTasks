package com.javarush.task.task24.task2405;

/* 
Black box
*/
public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //!!!!! Changes can be here
        //!!!!! Изменения могут быть тут

        public void someAction() {
            //!!!!! All changes have to be here
            //!!!!! Все изменения должны быть только тут
            //создаем экземпляр класса SecondClass с переопределнным под условие задачи методом someAction()
            final SecondClass secondClass = new SecondClass(){
                @Override
                public void someAction() {
                    super.someAction();
                    System.out.println(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.substring(1) + param);
                }
            };
            //если param > 0 создаем анонимный FristClass с переопределнным под условие задачи методом someAction()
            if (param > 0) {
                new FirstClass() {
                    @Override
                    public void someAction() {
                        while (param > 0) {
                            System.out.println(param--);
                        }
                        super.someAction();//первоначальный метод someAction() FirstClass
                        this.getDependantAction().someAction(); //переопределенный выше метод someAction() SecondClass
                    }
                    @Override
                    public Action getDependantAction() { //в реализации абстрактного метода возвращаем экземпляр SecondClass
                        return secondClass;
                    }
                }.someAction();
            }
            else {
                //если param < 1 то вызываем переопределенный выше метод someAction() SecondClass
                secondClass.someAction();
            }
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
