package me.marlester.eaahf.mixin;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net/minecraft/inventory/container/PlayerContainer$1"})
public class ESMixin {
  EquipmentSlotType val$equipmentslottype;
  @Inject(method = "mayPlace(Lnet/minecraft/item/ItemStack;)Z", at = @At("RETURN"), cancellable = true)
  public void allowItemEquipping(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
    if (val$equipmentslottype == EquipmentSlotType.HEAD) {
      cir.setReturnValue(true);
    }
  }
}