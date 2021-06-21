package edu.rit.connors.brandon.swcompanion.core.adapters;

import java.util.ArrayList;
import java.util.ListIterator;

import edu.rit.connors.brandon.swcompanion.core.models.ListItem;

public interface IListAdapter {
    void setItems(ArrayList<ListItem> items);
    void clearItems();
}
