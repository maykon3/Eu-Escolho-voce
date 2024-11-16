<h1>Eu Escolho Você - Aplicativo Android</h1>

<p>Este é um aplicativo simples para Android que ajuda o usuário a escolher um filme aleatório de diferentes gêneros, perguntas para quebrar o gelo naquele primeio encontro, festas de familia, ou caso o time do seu amigo perca aquele jogo importante, mas tambem te auxlia na escolha de qual será o jantar da noite . O aplicativo exibe imagens, frases e uma roleta com comidas aleatoriamente, proporcionando uma experiência de escolha divertida e descomplicada.</p>

<h2>Tecnologias Utilizadas</h2>
<ul>
    <li><strong>Linguagem:</strong> Kotlin</li>
    <li><strong>Framework de UI:</strong> Jetpack Compose</li>
    <li><strong>Biblioteca de Design:</strong> Material 3</li>
    <li><strong>Prototipo: </strong> Figma </li>
</ul>

<h2>Estrutura do Projeto</h2>
<p>O projeto inclui as seguintes partes principais:</p>
<ol>
    <li><code>MainActivity.kt</code>: Configura a interface do usuário e define a estrutura da aplicação com <code>setContent</code>.</li>
    <li>Função <code>Inicio</code>: Componente de tela principal que exibe o texto, imagem e botão para selecionar um filme. Ele usa um sorteio aleatório para escolher uma imagem e um nome de gênero.</li>
    <li>Arquivos de Recursos: Imagens e outros recursos estão disponíveis na pasta <code>res/drawable</code>.</li>
</ol>

<h2>Funcionalidades</h2>
<ul>
    <li><strong>Exibição Aleatória de Filmes:</strong> Ao clicar no botão "Escolher", um gênero e uma imagem são sorteados e exibidos na tela.</li>
     <li><strong>Escolha de perguntas aleatorias:</strong> Ao clicar no botão "Escolher", uma pergunta sobre determinado tema são sorteados e exibidos na tela.</li>
    <li><strong>Escolha do Jantar em Familía:</strong> Ao clicar no botão "Escolher", a roleta gira para um determinado alimento, com a sinalização de uma seta vermelha, junto com a menssagem de qual vai ser o jantar daquela noite.</li>
    <li><strong>Compatibilidade com Edge-to-Edge:</strong> Interface otimizada para telas completas em dispositivos modernos.</li>
</ul>

<h2>Pré-requisitos</h2>
<ul>
    <li><strong>Android Studio</strong> (última versão recomendada)</li>
    <li><strong>Emulador Android</strong> ou dispositivo físico para teste</li>
</ul>

<h2>Como Executar</h2>
<ol>
    <li>Clone este repositório:
        <pre><code>git clone https://github.com/seu_usuario/escolha</code></pre>
    </li>
    <li>Abra o projeto no Android Studio.</li>
    <li>Conecte um dispositivo ou inicie um emulador.</li>
    <li>Execute o aplicativo pressionando <strong>Run</strong>.</li>
</ol>

