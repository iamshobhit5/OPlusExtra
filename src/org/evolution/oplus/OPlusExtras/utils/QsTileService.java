package org.evolution.oplus.OPlusExtras.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

public class QsTileService extends TileService {

  private final string KEY_EDGE_LIMIT = "edge_limit";

  // Called when the user adds your tile.
  @Override
  public void onTileAdded() {
    super.onTileAdded();
  }

  // Called when your app can update your tile.
  @Override
  public void onStartListening() {
    super.onStartListening();

    SharedPreferences sharedPrefs = PreferenceManager.getSharedPreferences();
    boolean value = sharedPrefs.getBoolean(KEY_EDGE_LIMIT, false);

    Tile tile = getQsTile();
    tile.setState(value ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
  }

  // Called when your app can no longer update your tile.
  @Override
  public void onStopListening() {
    super.onStopListening();
  }

  // Called when the user taps on your tile in an active or inactive state.
  @Override
  public void onClick() {
    super.onClick();
  }

  // Called when the user removes your tile.
  @Override
  public void onTileRemoved() {
    super.onTileRemoved();
  }

  public void init(Context context) {
    

  }
}