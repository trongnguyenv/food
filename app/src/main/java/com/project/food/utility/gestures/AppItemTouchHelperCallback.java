package com.project.food.utility.gestures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.project.food.utility.animations.ViewHolderItemTouchHelper;

public class AppItemTouchHelperCallback extends ItemTouchHelper.Callback{
    private final AppItemTouchHelper itemTouchHelper;

    public AppItemTouchHelperCallback(AppItemTouchHelper itemTouchHelper) {
        this.itemTouchHelper = itemTouchHelper;
    }

    // Inform ItemTouchHelper of supported movement directions; Drag directions & Swipe directions
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    // Notify adapter that an item has been moved thus update item's new positioning
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        if(viewHolder.getItemViewType() != target.getItemViewType()){
            return false;
        }
        itemTouchHelper.onItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    // Notify adapter that an item has been swiped and thus delete item in list
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        itemTouchHelper.onItemSwiped(viewHolder.getAdapterPosition());
    }

    // Trigger animations for selected viewholder
    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        // Ensure animations only apply for unselected viewholders
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            if (viewHolder instanceof ViewHolderItemTouchHelper) {
                //  Notify viewholder that an item is being dragged
                ViewHolderItemTouchHelper itemViewHolder = (ViewHolderItemTouchHelper) viewHolder;
                itemViewHolder.onItemSelected();
            }
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    // Trigger animations for unselected viewholder
    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (viewHolder instanceof ViewHolderItemTouchHelper) {
            //  Clear animations for unselected items
            ViewHolderItemTouchHelper itemViewHolder = (ViewHolderItemTouchHelper) viewHolder;
            itemViewHolder.onItemUnselected();
        }
    }
}
