package me.marlester.eaahforge.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net/minecraft/world/inventory/ArmorSlot"})
public class ESMixin {
  EquipmentSlot slot;
  @Inject(method = "mayPlace(Lnet/minecraft/world/item/ItemStack;)Z", at = @At("RETURN"), cancellable = true)
  public void allowItemEquipping(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
    if (slot == EquipmentSlot.HEAD) {
      cir.setReturnValue(true);
    }
  }
}