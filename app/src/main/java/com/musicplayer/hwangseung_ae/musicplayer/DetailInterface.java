package com.musicplayer.hwangseung_ae.musicplayer;

import java.sql.SQLException;

/**
 * Created by pc on 2/14/2017.
 */

public interface DetailInterface {
    public void backToList();
    public void saveToList(Memo memo) throws SQLException;
}
