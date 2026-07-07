package june.module12.inventory.service;

import june.module12.inventory.entity.Inventory;
import june.module12.inventory.repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepo inventoryRepo;
    public void addProduct(Inventory inventory){
        inventoryRepo.save(inventory);
    }

    public boolean reduceStock(Long productId, Integer qty){
        Inventory inventory = inventoryRepo.findById(productId).orElseThrow(()-> new RuntimeException("Not Found"));
        if(inventory.getQuantity() < qty){
            return false;
        }
        inventory.setQuantity(inventory.getQuantity() - qty);
        inventoryRepo.save(inventory);
        return true;
    }

    public void restock(Long productId, Integer qty) {
        Inventory inventory = inventoryRepo.findById(productId).orElseThrow();
        inventory.setQuantity(inventory.getQuantity() + qty);
        inventoryRepo.save(inventory);
    }
}
