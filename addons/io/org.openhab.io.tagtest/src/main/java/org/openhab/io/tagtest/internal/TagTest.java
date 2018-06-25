/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.io.tagtest.internal;

import java.util.Collection;
import java.util.Map;

import org.eclipse.smarthome.core.items.Item;
import org.eclipse.smarthome.core.items.ItemRegistry;
import org.eclipse.smarthome.core.items.ItemRegistryChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Pepijn de Geus - Initial contribution
 */
public class TagTest implements ItemRegistryChangeListener {

    private final Logger logger = LoggerFactory.getLogger(TagTest.class);

    private ItemRegistry itemRegistry;

    protected void activate(Map<String, Object> config) {
        logger.info("Tag test activating");
        itemRegistry.addRegistryChangeListener(this);
    }

    protected void deactivate() {
        logger.info("Tag test deactivating");
        itemRegistry.removeRegistryChangeListener(this);
    }

    protected void setItemRegistry(ItemRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    protected void unsetItemRegistry(ItemRegistry itemRegistry) {
        this.itemRegistry = null;
    }

    @Override
    public void allItemsChanged(Collection<String> collection) {
        //nothing
    }

    @Override
    public void added(Item item) {
        logger.info("Item added: '{}', tags: {}", item.getName(), item.getTags());
    }

    @Override
    public void removed(Item item) {
        //nothing
    }

    @Override
    public void updated(Item oldItem, Item newItem) {
        logger.info("Item updated: '{}', old tags: {}, new tags: {}", newItem.getName(), oldItem.getTags(), newItem.getTags());
    }

}
