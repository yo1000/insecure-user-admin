# INSECURE USER ADMIN
セキュリティプログラミングの初学者向けに教材として作成した、
脆弱なユーザー管理システムです。

重要なデータは、ぜったいに このシステムでは扱わないでください。


## How to start

```
$ git clone https://github.com/yo1000/insecure-user-admin.git
$ cd insecure-user-admin
$ ./mvnw spring-boot:run
```

## Exercise

### Step1
入力を工夫し、エラーを誘発して、実行される SQL を調べてみましょう。

### Step2
調べた SQL をもとに、不正ログインしてみましょう。

### Step3
ログインしたユーザー管理システムで、パスワードを不正に入手しましょう。

### Step4
どのような対策をしておけば、このような不正を防止することが出来たか、考えてみましょう。
