package org.evolution.oplus.OPlusExtras.utils;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

import org.evolution.oplus.OPlusExtras.utils.Utils;
import org.evolution.oplus.OPlusExtras.Nodes;

public class QsTileService extends TileService {

  private final String KEY_EDGE_LIMIT = "edge_limit";

  // Called when the user adds your tile.
  @Override
  public void onTileAdded() {
    super.onTileAdded();
  }

  // Called when your app can update your tile.
  @Override
  public void onStartListening() {
    super.onStartListening();

    SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
    boolean value = sharedPrefs.getBoolean(KEY_EDGE_LIMIT, false);

    Tile tile = getQsTile();
    tile.setState(value ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);

    tile.updateTile();
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

    SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
    boolean value = sharedPrefs.getBoolean(KEY_EDGE_LIMIT, false);

    sharedPrefs.edit().putBoolean(KEY_EDGE_LIMIT, !value).commit();
    Utils.writeValue(Nodes.nodeEdgeLimit(this), !value ? "1" : "0");

    Tile tile = getQsTile();
    tile.setState(!value ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
    tile.updateTile();
  }

  // Called when the user removes your tile.
  @Override
  public void onTileRemoved() {
    super.onTileRemoved();
  }

  public void init(Context context) {
    

  }
}