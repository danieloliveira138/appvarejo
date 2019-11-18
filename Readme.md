## Desafio Via Varejo

Desafio realizado para o processo seletivo da Via Varejo

#### Desafio

Criado o aplicativo a partir do repositório: [Desafio Android](https://bitbucket.org/devmobila/desafio-android/src/master/) 

##### Libs Utilizadas

 [Glide](https://github.com/bumptech/glide): Carregamento de imagens
 [Retrofit](https://square.github.io/retrofit/): Retrofit: Para consumir a Api com informações dos produtos
 [Rx](https://github.com/ReactiveX/RxAndroid): Para tratar as chamadas REST de forma assíncrona.
 [Anko](https://github.com/Kotlin/anko): Para aumentar a produtividade e facilitar o uso de recursos do SDK do Android
 [KTX](https://developer.android.com/kotlin/ktx?gclid=Cj0KCQiAn8nuBRCzARIsAJcdIfOXYnUCIrYXkxn6wnnaaglEQPoRYFKHVRAJMhTCo_zd_oVKDc03aAcaAr3ZEALw_wcB): Para acelerar o desenvolvimento
 [Koin](https://insert-koin.io/): Para injeção de dependências.
 

##### Arquitetura

Utilizei o padrão de arquitetura MVVM, sugerida pelo google e baseada nos preceitos do cleancode. A View tem reponsabilidade apenas de controlar os componentes visuais da tela enquanto a classe ViewModel ccontrola toda a lógica de negócio de cada tela.
Utilizei uma classe de Repositório que trata as chamadas a Api, atuando como uma camada entre as chamadas a API e a Lógica de negócios da ViewModel.

##### Desafios do projeto.

O grande desafio foi reutilizar os componentes entre as telas, para isso utilizei um recyclerview nas duas telas, com isso as views(holders) instanciados pelos adapters desses recyclers podem ser reutilizados em outras telas, dependendo da nescessidade do projeto.
Tentei reutilizar ao máximo os elementos das telas xml, para aumentar a produtividade.
