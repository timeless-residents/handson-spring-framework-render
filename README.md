# Spring Boot デモアプリケーション

このプロジェクトは、Spring Bootを使用した基本的なRESTful APIのデモンストレーションです。

## 開発環境要件

- Java 17以上
- Maven 3.6以上
- Spring Boot 3.x

## セットアップ手順

1. リポジトリをクローンします：
```bash
git clone [リポジトリURL]
```

2. プロジェクトディレクトリに移動：
```bash
cd handson-spring-framework-render
```

3. アプリケーションを実行：
```bash
./mvnw spring-boot:run
```

アプリケーションは `http://localhost:8080` で起動します。

## API エンドポイント

### Hello エンドポイント
- GET `/api/hello` - 基本的な挨拶メッセージを返します

### Book エンドポイント
- GET `/api/books` - すべての本のリストを取得
- GET `/api/books/{id}` - 指定されたIDの本を取得
- POST `/api/books` - 新しい本を追加
- PUT `/api/books/{id}` - 既存の本を更新
- DELETE `/api/books/{id}` - 指定されたIDの本を削除

## API ドキュメント

アプリケーション起動後、以下のURLでSwagger UIを通じてAPIドキュメントにアクセスできます：
```
http://localhost:8080/swagger-ui.html
```

## プロジェクト構造

```
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── controller/    - APIエンドポイントの制御
│   │       ├── entity/        - データモデル
│   │       ├── repository/    - データアクセス層
│   │       └── config/        - アプリケーション設定
│   └── resources/
│       ├── application.properties  - アプリケーション設定
│       └── application.yml         - 追加設定
```

## デプロイメント

このアプリケーションはDockerを使用してコンテナ化できます。Dockerfileが含まれています。

ビルドとデプロイ：
```bash
docker build -t spring-demo .
docker run -p 8080:8080 spring-demo
```

## ライセンス

このプロジェクトはMITライセンスの下で公開されています。
