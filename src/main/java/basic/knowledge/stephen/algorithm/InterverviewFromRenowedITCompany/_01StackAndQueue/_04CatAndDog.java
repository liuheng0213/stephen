package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01StackAndQueue;

import java.util.LinkedList;

public class _04CatAndDog {

    public static void main(String[] args) {
        _04CatAndDog catAndDog = new _04CatAndDog();
        catAndDog.add(new Cat());
        catAndDog.add(new Cat());
        catAndDog.add(new Cat());
        catAndDog.add(new Dog());
        catAndDog.add(new Dog());
        catAndDog.add(new Dog());
        catAndDog.add(new Cat());
        catAndDog.add(new Dog());
        catAndDog.pollDog();
        catAndDog.add(new Cat());

        while(!catAndDog.isEmpty()){
            System.out.println(catAndDog.pollAll());
        }

       /* while(!catAndDog.isCatEmpty()){
            System.out.println(catAndDog.pollCat());
        }*/
/*
        while(!catAndDog.isDogEmpty()){
            System.out.println(catAndDog.pollDog());
        }*/



    }

    private boolean isEmpty() {
        return isDogEmpty() && isCatEmpty();
    }

    private boolean isDogEmpty(){
        return this.dogQ.isEmpty();
    }

    private boolean isCatEmpty(){
        return this.catQ.isEmpty();
    }

    private LinkedList<Animal> dogQ;
    private LinkedList<Animal> catQ;
    private long count;

    public _04CatAndDog() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Animal animal){
        animal.setCount(this.count++);
        if(animal instanceof Dog){
            this.dogQ.add(animal);
        }else if (animal instanceof Cat){
            this.catQ.add(animal);
        }else{
            throw new RuntimeException("empty");
        }
    }

    public Animal pollAll(){
        if(!dogQ.isEmpty() && ! catQ.isEmpty()){
            if(this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                return this.dogQ.poll();
            }else{
                return this.catQ.poll();
            }
        }else if(!dogQ.isEmpty()){
            return this.dogQ.poll();
        }else if(!catQ.isEmpty()){
            return this.catQ.poll();
        }else{
            throw new RuntimeException("empty");
        }
    }

    public Dog pollDog(){
        if(!this.dogQ.isEmpty()){
            return (Dog) this.dogQ.poll();
        }else{
            throw new RuntimeException("empty");
        }
    }

    public Cat pollCat(){
        if(!this.catQ.isEmpty()){
            return (Cat) this.catQ.poll();
        }else{
            throw new RuntimeException("empty");
        }
    }
}

abstract  class Animal {
    long count;


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}

class Dog extends Animal{
    String type;

    public Dog() {
        this.type = "dog";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "count=" + count +
                ", type='" + type + '\'' +
                '}';
    }
}

class Cat extends Animal{
    String type;

    public Cat() {
        this.type = "cat";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "count=" + count +
                ", type='" + type + '\'' +
                '}';
    }
}
