# 🌳 Projeto: Árvore Binária – Código Morse

## 1️⃣ Contexto e objetivo do projeto

O projeto consiste na implementação **manual** de uma árvore binária para representar o **código Morse**, obedecendo a regras restritivas impostas pelo professor:

Cada caractere (letra ou número) é armazenado em um **nó da árvore**, cujo caminho é definido pela sua representação em código Morse:

- O **ponto (.)** indica o movimento para o **nó à esquerda**.
- O **traço (-)** indica o movimento para o **nó à direita**.

Assim, cada caminho único da raiz até um nó representa **um caractere específico**.

---

## 2️⃣ Estrutura e funcionamento do projeto

O sistema foi dividido em **três classes principais**, cada uma com uma função bem definida:

### 🧩 Classe `Node.java`

Define a estrutura básica do nó da árvore binária.

Cada nó contém:

- Um caractere (`char c`);
- Um filho à esquerda (`Node left`);
- Um filho à direita (`Node right`).

---

### 🌳 Classe `ArvoreBinariaMorse.java`

Contém toda a lógica da árvore e as funcionalidades exigidas no trabalho:

- `inserir(String codigo, char caractere)`  
  Insere um caractere na árvore, criando os nós conforme os pontos e traços do código Morse.

- `buscar(String codigo)`  
  Percorre a árvore a partir da raiz e retorna o caractere correspondente ao código Morse informado.

- `buscarCodigo(char letra)`  
  Faz o processo inverso: percorre toda a árvore recursivamente e retorna o **código Morse** correspondente a uma letra ou número.

- `remover(String codigo)`  
  Limpa o valor armazenado no nó, **sem destruir a estrutura**, garantindo que os demais caminhos continuem válidos.

- `exibir()`  
  Mostra a árvore hierarquicamente no terminal, indicando os ramos com pontos (.) e traços (-).

- `inicializar()`  
  Insere **todas as letras (A–Z)** e **números (0–9)** de forma manual, **sem uso de arrays** ou estruturas automatizadas.

---

### 💻 Classe `Main.java`

Responsável pela **interação com o usuário** via terminal.

Possui um menu textual simples e intuitivo que permite:

1. Exibir Árvore
2. Buscar letra (código Morse → letra)
3. Buscar código (letra → código Morse)
4. Inserir novo caractere
5. Remover caractere
0. Sair

---

## 🔢 3️⃣ Exemplo de execução

```
=== ÁRVORE BINÁRIA - CÓDIGO MORSE ===

==============================
1 - Exibir Árvore
2 - Buscar letra (código Morse → letra)
3 - Buscar código (letra → código Morse)
4 - Inserir novo caractere
5 - Remover caractere
0 - Sair
Escolha uma opção:
```

---

## 🧠 4️⃣ Representação visual da árvore

Ao exibir a árvore no terminal (`opção 1`), o resultado segue o padrão:

( )
.(E)
. .(I)
. . .(S)
. . . .(H)
. . . . .(5)
...

markdown
Copiar código

Explicação:

- Cada **( )** representa um **nó existente, mas sem caractere associado** (nó vazio).
- Cada **ponto (.)** indica uma **ramificação à esquerda**.
- Cada **traço (-)** indica uma **ramificação à direita**.
- Essa forma hierárquica reflete exatamente a estrutura binária do código Morse.

---

## ⚙️ 5️⃣ Justificativa técnica e pedagógica

- A **árvore binária** reflete naturalmente a estrutura do **código Morse**, que é essencialmente binária (ponto/traço).
- A **recursão** foi usada para percorrer e exibir a árvore sem usar listas ou arrays.
- O método de **remoção** apenas limpa o caractere, mantendo o nó, conforme a exigência de “não perder os dados da sequência”.
- O método `buscarCodigo()` complementa o projeto, permitindo a conversão nos dois sentidos (Morse ↔ texto).

---

## 🧾 Estrutura do projeto

```
.
├── Main.java
├── ArvoreBinariaMorse.java
└── Node.java
```
