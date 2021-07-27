package com.ethan.aidlservice.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import java.util.List;

//public interface HeroesInterface extends IInterface {
//    /**
//     * Stub
//     * <p>
//     * HeroesInterface 接口的实现类，继承自 Binder。服务端创建该实例返给客户端
//     */
//    public static abstract class Stub extends Binder implements HeroesInterface {
//
//        public static HeroesInterface asInterface(IBinder obj) {
//            // 客户端首先在当前进程查询是否有这个接口实现类的对象，如果有则直接使用。说明不涉及 IPC
//            // 如果没有则创建一个代理对象
//            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
//
//            if (((iin != null) && (iin instanceof HeroesInterface))) {
//                // 在当前进程找到该接口实现类对象，直接返回
//                return ((HeroesInterface) iin);
//            }
//            // 当前进程中找不到，那就创建一个代理对象
//            // 需要代理一下，因为在像服务器发请求之前需要处理一下数据
//            return new HeroesInterface.Stub.Proxy(obj);
//        }
//
//        /**
//         * onTransact 方法运行在远程服务端 的Binder连接池中
//         *
//         * @param code  方法代号
//         * @param data  客户端请求数据
//         * @param reply 返回给客户端的值
//         * @param flags
//         * @return
//         * @throws android.os.RemoteException
//         */
//        @Override
//        public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
//                throws android.os.RemoteException {
//            String descriptor = DESCRIPTOR;
//
//            switch (code) {
//                case INTERFACE_TRANSACTION: {
//                    reply.writeString(descriptor);
//                    return true;
//                }
//                case TRANSACTION_addHero: {
//                    Hero hero;
//                    // 将客户端传来的 data反序列化
//                    hero = Hero.CREATOR.createFromParcel(data);
//                    // 将反序列化的数据存入 Service
//                    this.addHero(hero);
//                    ......
//                    return true;
//                }
//                case TRANSACTION_getHeroes: {
//                    // 获取服务端列表数据
//                    List<Hero> _result = this.getHeroes();
//                    // 将查询到的数据返回给客户端
//                    reply.writeTypedList(_result);
//                    return true;
//                }
//                default: {
//                    return super.onTransact(code, data, reply, flags);
//                }
//            }
//        }
//
//        private static class Proxy implements HeroesInterface {
//            private IBinder mRemote;
//            Proxy(IBinder remote) {
//                mRemote = remote;
//            }
//
//            @Override
//            public void addHero(Hero hero) throws RemoteException {
//                Parcel _data = Parcel.obtain();
//                Parcel _reply = Parcel.obtain();
//                try {
//                    ......
//                    // 将客户端请求添加的对象 hero写进 Parcel对象里
//                    hero.writeToParcel(_data, 0);
//                    ......
//                    // 客户端调用远程服务端返回的 Binder（mRemote）的transact方法写入数据
//                    // Stub.TRANSACTION_addHero : 方法代号code
//                    // _data : 客户端请求添加的数据
//                    // _reply : 当方法有返回值的话，调用完该方法会返回该值
//
//                    boolean _status = mRemote.transact(Stub.TRANSACTION_addHero, _data, _reply, 0);
//                    ......
//                } finally {
//                    _reply.recycle();
//                    _data.recycle();
//                }
//            }
//
//            @Override
//            public java.util.List<Hero> getHeroes() throws android.os.RemoteException {
//                Parcel _data = android.os.Parcel.obtain();
//                Parcel _reply = android.os.Parcel.obtain();
//                List<Hero> _result;
//
//                try {
//                    // 客户端调用远程服务器的 Binder的 transact 方法
//                    boolean _status = mRemote.transact(Stub.TRANSACTION_getHeroes, _data, _reply, 0);
//                    ......
//                    // 获取服务器返回结果
//                    _result = _reply.createTypedArrayList(Hero.CREATOR);
//                } finally {
//                    _reply.recycle();
//                    _data.recycle();
//                }
//                return _result;
//            }
//        }
//    }
//}
