# INSECURE USER ADMIN
セキュアプログラミングの初学者向けに教材として作成した、  
脆弱なユーザー管理システムです。

重要なデータは、ぜったいに このシステムでは扱わないでください。


## How to start

```
$ git clone https://github.com/yo1000/insecure-user-admin.git
$ cd insecure-user-admin
$ ./mvnw spring-boot:run
```

ブラウザで URL にアクセスします。  
[http://localhost:8080/](http://localhost:8080/)

もし、`8080` ポートが空いていない場合、  
起動コマンドを、以下の様に変更して試してみてください。

```
$ ./mvnw spring-boot:run -Dserver.port=18080
```

アプリケーションが、`18080` ポートで起動するので、  
改めて以下の URL にアクセスします。  
[http://localhost:18080/](http://localhost:18080/)

## Exercise

### Step1
入力を工夫し、エラーを誘発して、実行される SQL を調べてみましょう。

### Step2
調べた SQL をもとに、不正ログインしてみましょう。

### Step3
ログインしたユーザー管理システムで、パスワードを不正に入手しましょう。

### Step4
どのような対策をしておけば、このような不正を防止することが出来たか、考えてみましょう。
