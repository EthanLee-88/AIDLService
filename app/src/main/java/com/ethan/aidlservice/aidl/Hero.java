// 注释 1，这里的包名一定要和 Hero.aidl 文件的包名相同 ！
package com.ethan.aidlservice.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/****************
 * 一个类实现 Parcelable接口，就需要重写两个方法：writeToParcel(Parcel out, int i)(序列化) 、describeContents（）
 *  需定义 CREATOR 变量并赋值，反序列化过程由该实例实现。
 *  此外还需一个带 Parcel形参的构造器，以实现 CREATOR 内部的反序列化对象的创建
 * ********************/
// 实现 Parcelable可序列换接口
public class Hero implements Parcelable {
    // 真名
    private String realName;
    // 昵称
    private String nickName;
    // 英雄类型
    private String heroType;

    public Hero() {
    }

    public Hero(String realName, String nickName, String heroType) {
        this.realName = realName;
        this.nickName = nickName;
        this.heroType = heroType;
    }

    private Hero(Parcel in) {
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        this.realName = in.readString();
        this.nickName = in.readString();
        this.heroType = in.readString();
    }

    /**
     * 实例化静态内部对象CREATOR实现接口Parcelable.Creator
     * 这是用于将对象反序列化的（读取）
     */
    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int i) {
            return new Hero[i];
        }
    };

    /**
     * 重写writeToParcel方法，将 Hero对象序列化为一个Parcel对象
     * 这是用于将对象序列化的（写入）
     *
     * @param out 输出
     * @param i
     */
    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(realName);
        out.writeString(nickName);
        out.writeString(heroType);
    }

    /**
     * 重写describeContents方法，内容接口描述，默认返回0就可以
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("[%s , %s , %s ]\n", realName, nickName, heroType);
    }
}
