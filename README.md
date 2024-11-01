# Escolha de Filme - Aplicativo Android<br>
<br>
Este é um aplicativo simples para Android que ajuda o usuário a escolher um filme aleatório de diferentes gêneros, como Terror, Comédia, Ação, Romance e Suspense. O aplicativo exibe a imagem e o nome do gênero selecionado aleatoriamente, proporcionando uma experiência de escolha divertida e descomplicada.
<br>
## Tecnologias Utilizadas
<br>
- **Linguagem:** Kotlin
- **Framework de UI:** Jetpack Compose
- **Biblioteca de Design:** Material 3
<br>
## Estrutura do Projeto
<br>
O projeto inclui as seguintes partes principais:
<br>
1. **`MainActivity.kt`:** Configura a interface do usuário e define a estrutura da aplicação com `setContent`.<br>
2. **Função `Inicio`:** Componente de tela principal que exibe o texto, imagem e botão para selecionar um filme. Ele usa um sorteio aleatório para escolher uma imagem e um nome degênero.<br>
3. **Arquivos de Recursos:** Imagens e outros recursos estão disponíveis na pasta `res/drawable`.<br>
<br>
## Funcionalidades
<br>
- **Exibição Aleatória de Filmes:** Ao clicar no botão "Escolher", um gênero e uma imagem são sorteados e exibidos na tela.<br>
- **Estilos Personalizados:** Utilização do Material 3 para um design moderno, incluindo cores, fontes e componentes como `Card` e `Button`.<br>
- **Compatibilidade com Edge-to-Edge:** Interface otimizada para telas completas em dispositivos modernos.<br>
<br>
## Pré-requisitos
<br>
- **Android Studio** (última versão recomendada)<br>
- **Emulador Android** ou dispositivo físico para teste
