// HeroesInterface.aidl
// 包名别搞错
package com.ethan.aidlservice.aidl;

// 要手动引用这个包，记得包名一定要对上
import com.ethan.aidlservice.aidl.Hero;
import com.ethan.aidlservice.aidl.OnNewHeroJoinListener;

interface HeroesInterface {

  void addHero(in Hero hero);
  List<Hero> getHeroes();

  void registerListener(OnNewHeroJoinListener onNewHeroJoinListener);
  void unRegisterListener(OnNewHeroJoinListener onNewHeroJoinListener);
}