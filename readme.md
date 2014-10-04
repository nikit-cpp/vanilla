Deploing to phone
=================
[link](http://stand.spree.de/wiki_details_maven_archetypes "maven-android-archetypes")  
`mvn clean package android:deploy`

Решение проблем
===============
Проект не собирается, требует Android Support Library (com.android.support:support-v4)
--------------------------------------------------------------------------------------
`[INFO] BUILD FAILURE`  
`[INFO] ------------------------------------------------------------------------`  
`[INFO] Total time: 4.281s`  
`[INFO] Finished at: Sun Sep 21 02:08:36 GMT+03:00 2014`  
`[INFO] Final Memory: 10M/26M`  
`[INFO] ------------------------------------------------------------------------`  
`[ERROR] Failed to execute goal on project vanilla: Could not resolve dependencies for project com.github.nikit-cpp:vanilla:apk:1.0: Failure to find com.android.support:support-v4:jar:19.0.1 in http://repo.maven.apache.org/maven2 was cached in the local repository, resolution will not be reattempted until the update interval of central has elapsed or updates are forced -> [Help 1]`  
`[ERROR]`  
Возникает из-за отсутствия артефакта `com.android.support:support-v4:jar:19.0.1` в maven-central из-за политики Google. Решается одним из 2-х способов:  
 * скачиванием Android Support Repository из Android SDK Manager:  
![](http://img-fotki.yandex.ru/get/6741/165433899.1/0_1242a3_78c70b2a_orig)  
и добавлением в pom.xml дополнительного репозитория, в url которого -- file://путь_до_AndroidSupportRepository:  
`<repositories>`  
`	<repository>`  
`		<id>local-android-support-repository</id>`  
`		<url>file://C:/JavaInstruments/android-sdk-23/extras/android/m2repository</url>`  
`	</repository>`  
`</repositories>`  
после того как проект соберётся, дополнительный локальный репозиторий можно закоммментировать обратно  
 * при помощи утилиты [maven-android-sdk-deployer](https://github.com/mosabua/maven-android-sdk-deployer)  

Не работают тесты в IntelliJ IDEA, хотя mvn test работает
---------------------------------------------------------
![Не работают тесты](http://img-fotki.yandex.ru/get/6746/165433899.1/0_1262aa_b25db1fa_orig)  
Проблема у меня возникла после импорта, когда я на одном из шагов в `/home/nik/IdeaProjects/vanilla` убрал `vanilla`,
чтобы в результате получилось `/home/nik/IdeaProjects/vanilla` а не `/home/nik/IdeaProjects/vanilla/vanilla`  
Решается добавлением `vanilla` в "Working directory" в конфигурации запуска теста:  
![Добавление vanilla в Working directory](http://img-fotki.yandex.ru/get/6839/165433899.1/0_1262ab_cdae88be_orig)  
плюс Maven -> Reimport и  
Build -> Rebuild Project