/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl.contacts;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.*;

public class ImportContacts extends TLObject {

    public static final int ID = -634342611;

    public TLVector<TLInputContact> contacts;
    public boolean replace;

    public ImportContacts(TLVector<TLInputContact> contacts, boolean replace){
        this.contacts = contacts;
        this.replace = replace;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        contacts = (TLVector<TLInputContact>) buffer.readTLObject(APIContext.getInstance());
        replace = buffer.readBool();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeTLObject(contacts);
        buff.writeBool(replace);
    }

    public int getConstructor() {
        return ID;
    }
}