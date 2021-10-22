package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        Pet returnPet = null;
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                returnPet = pet;
            }
        }
        return returnPet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The grooming salon has the following clients:")
                .append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName())
                    .append(" ")
                    .append(pet.getOwner())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
