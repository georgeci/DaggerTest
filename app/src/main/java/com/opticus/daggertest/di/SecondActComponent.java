package com.opticus.daggertest.di;

import com.opticus.daggertest.SecondActivity;
import com.opticus.daggertest.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = {AppComponent.class}, modules = {SecondActModule.class})
public interface SecondActComponent extends SecondFrComponent.PlusComponent {
    void inject(SecondActivity activity);
}
