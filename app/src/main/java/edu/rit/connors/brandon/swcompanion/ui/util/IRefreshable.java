package edu.rit.connors.brandon.swcompanion.ui.util;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public interface IRefreshable extends SwipeRefreshLayout.OnRefreshListener {
    void setLoading(boolean isLoading);
}
