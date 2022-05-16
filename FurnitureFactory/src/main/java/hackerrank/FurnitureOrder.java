package hackerrank;


import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {


    /**
     * TODO: Create a map of Furniture items to order quantities
     */

    private Map<Furniture, Integer> furnitureMap;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        furnitureMap = new ConcurrentHashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {

        Optional.of(type)
                .map(furniture -> {
                    final Integer existingCount = Optional.ofNullable(furnitureMap.get(type))
                            .orElse(0);
                    final Integer newCount = existingCount + furnitureCount;
                    furnitureMap.put(type, newCount);
                    return furniture;
                }).orElseThrow( () -> new RuntimeException("furniture type cannnot be null"));



        // TODO: Complete the method
    }

    public Map<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return furnitureMap;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        return (float) furnitureMap.entrySet().stream()
                .map(entry -> entry.getKey().cost() *  entry.getValue())
                .collect(Collectors.toList())
                .stream()
                .mapToDouble(Float::floatValue).sum();
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        return Optional.ofNullable(furnitureMap.get(type))
                .orElse(0);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        return Optional.ofNullable(furnitureMap.get(type))
                .orElse(0) * type.cost();
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        return furnitureMap.entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}