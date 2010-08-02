/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gallery3d.ui;


/**
 * Selectable StateView.
 */
public abstract class TapListenerView extends StateView implements SlotView.SlotTapListener {

    protected SelectionManager mSelectionManager;

    @Override
    public void onBackPressed() {
        if (mSelectionManager.isSelectionMode()) {
            mSelectionManager.leaveSelectionMode();
        } else {
            super.onBackPressed();
        }
    }

    protected abstract void startStateView(int slotIndex);

    /* (non-Javadoc)
     * @see com.android.gallery3d.ui.SlotView.SlotTapListener#onSingleTapUp(int)
     */
    @Override
    public void onSingleTapUp(int slotIndex) {
        if (!mSelectionManager.isSelectionMode()) {
            startStateView(slotIndex);
        } else {
            mSelectionManager.selectSlot(slotIndex);
        }
    }

    /* (non-Javadoc)
     * @see com.android.gallery3d.ui.SlotView.SlotTapListener#onLongTap(int)
     */
    @Override
    public void onLongTap(int slotIndex) {
        mSelectionManager.switchSelectionMode(slotIndex);
    }
}