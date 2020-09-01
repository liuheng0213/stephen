package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 * add pollAll pollDog pollCat isEmpty isDogEmpty  isCatEmpty
 */
public class _04CatAndDogQueue {
    private Queue<EnterQueue> catQueue;
    private Queue<EnterQueue> dogQueue;
    private int count;

    public _04CatAndDogQueue() {
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
        int count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dogQueue.add(new EnterQueue(pet, this.count++));
        } else if (pet.getType().equals("cat")) {
            this.catQueue.add(new EnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException();
        }
    }

    public Pet pollAll() {
        if (this.catQueue.isEmpty() && this.dogQueue.isEmpty()) {
            throw new RuntimeException();
        } else if (!this.catQueue.isEmpty() && !this.dogQueue.isEmpty()) {
            if (this.dogQueue.peek().count < this.catQueue.peek().count) {
                return this.dogQueue.poll().getPet();
            } else {
                return this.catQueue.poll().getPet();
            }
        } else if (!this.catQueue.isEmpty()) {
            return this.catQueue.poll().getPet();
        } else {
            return this.dogQueue.poll().getPet();
        }
    }


    public Dog pollDog() {
        if (!this.dogQueue.isEmpty()) {
            return (Dog) this.dogQueue.poll().getPet();
        } else {
            throw new RuntimeException();
        }
    }


    public Cat pollCat() {
        if (!this.catQueue.isEmpty()) {
            return (Cat) this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isEmpty() {
        return this.catQueue.isEmpty() && this.dogQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQueue.isEmpty();
    }

    class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

    }

    class Dog extends Pet {

        public Dog(String type) {
            super("dog");
        }
    }

    class Cat extends Pet {

        public Cat(String type) {
            super("cat");
        }
    }

    class EnterQueue {
        private Pet pet;
        private int count;


        public EnterQueue(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public int getCount() {
            return this.count;
        }

        public String getPetType() {
            return this.getPet().getType();
        }
    }
}
