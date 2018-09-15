package h.app.hackit.banana;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

class Flash implements Parcelable {
    String title;
    String desc;
    String type;
    private ArrayList<SubFlash> mList;

    public Flash(String title, String desc, String type) {
        this.title = title;
        this.desc = desc;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Flash(String title, ArrayList<SubFlash> mList, String type) {
        this.title = title;
        this.type = type;
        this.mList = mList;
    }

    protected Flash(Parcel in) {
        title = in.readString();
        desc = in.readString();
        type = in.readString();
        mList = in.createTypedArrayList(SubFlash.CREATOR);
    }

    public static final Creator<Flash> CREATOR = new Creator<Flash>() {
        @Override
        public Flash createFromParcel(Parcel in) {
            return new Flash(in);
        }

        @Override
        public Flash[] newArray(int size) {
            return new Flash[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<SubFlash> getmList() {
        return mList;
    }

    public void setmList(ArrayList<SubFlash> mList) {
        this.mList = mList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(desc);
        parcel.writeString(type);
        parcel.writeTypedList(mList);
    }
}

class SubFlash implements Parcelable {
    private String desc, hint;

    public SubFlash(String desc, String hint) {
        this.desc = desc;
        this.hint = hint;
    }

    protected SubFlash(Parcel in) {
        desc = in.readString();
        hint = in.readString();
    }

    public static final Creator<SubFlash> CREATOR = new Creator<SubFlash>() {
        @Override
        public SubFlash createFromParcel(Parcel in) {
            return new SubFlash(in);
        }

        @Override
        public SubFlash[] newArray(int size) {
            return new SubFlash[size];
        }
    };

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(desc);
        parcel.writeString(hint);
    }
}
