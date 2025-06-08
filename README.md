
# 🛒 Lista de Compras

## 📌 Descrição

Este projeto é uma aplicação de linha de comando desenvolvida em **Java** para gerenciamento de uma **lista de compras**. Ele permite ao usuário adicionar, listar, buscar, atualizar, remover e marcar/desmarcar itens como comprados. O objetivo é proporcionar uma solução simples e funcional para organizar e controlar os itens a serem adquiridos, diretamente pelo terminal.

---

## 🎯 Objetivo da Aplicação

Fornecer ao usuário uma maneira prática e intuitiva de gerenciar sua lista de compras, com operações CRUD completas (Criar, Ler, Atualizar, Deletar), além de permitir marcação de itens como comprados ou não.

---

## 🚀 Funcionalidades

- ✅ Adicionar item
- 📄 Listar todos os itens
- 🔍 Buscar item por ID
- ✏️ Atualizar item
- ❌ Remover item
- 🛍️ Marcar item como comprado
- 🔄 Desmarcar item como comprado
- 🧹 Limpar toda a lista

---

## 🛠️ Tecnologias Utilizadas

- **Java SE 17**
- **JDBC (Java Database Connectivity)**
- **MySQL/MariaDB** como banco de dados (porta padrão 3306)
- **JUnit 5** para testes automatizados
- **IDE** recomendada: IntelliJ IDEA / Eclipse
- **Maven** para gerenciamento de dependências

---

## 💻 Ambiente de Desenvolvimento

- **Sistema Operacional:** Windows 10 / 11 ou Linux
- **JDK:** Java Development Kit 17
- **MySQL:** Versão 8+ (porta 3306)
- **Editor/IDE:** IntelliJ IDEA, Eclipse ou VSCode com suporte Java
- **Banco de Dados:** MySQL/MariaDB com a seguinte configuração:

```sql
CREATE DATABASE IF NOT EXISTS listadecompras;
USE listadecompras;

CREATE TABLE IF NOT EXISTS lista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    comprado BOOLEAN DEFAULT FALSE
);
```

---

## 🧪 Testes Automatizados

O projeto inclui uma suíte de testes JUnit 5 que cobre as seguintes funcionalidades:

- Inserção de novo item
- Busca por item
- Atualização de item
- Marcação como comprado
- Remoção de item

---

## 📂 Estrutura do Projeto

```
listadecompras/
│
├── src/
│   ├── com.listadecompras/
│   │   ├── Main.java
│   │   ├── Item.java
│   │   └── ListaDAO.java
│
├── test/
│   ├── com.listadecompras/
│   │   └── ListaDAOTest.java
│
├── pom.xml
└── README.md
```

---

## 🧹 Código Limpo

- Utilização de nomes de variáveis e métodos descritivos
- Validação de entradas do usuário (por exemplo, quantidade e ID devem ser numéricos válidos)
- Utilização de loops e estrutura de decisão clara e simples
- Separação de responsabilidades em classes (`Main`, `Item`, `ListaDAO`)

---

## 🧩 Padrões de Projeto

- **DAO (Data Access Object):** Aplicado na classe `ListaDAO`, responsável por isolar a lógica de acesso ao banco de dados da lógica de apresentação (Main).

---

## ⚙️ Requisitos de Sistema

- Java 17 ou superior instalado
- Servidor MySQL ativo na porta 3306
- IDE para compilar e executar o projeto
- Maven configurado para resolver dependências (`mysql-connector-j`, `junit-jupiter`)

---

## ▶️ Como Executar a Aplicação

1. Clone este repositório:
   ```bash
   git clone https://github.com/Luan-Prudente/listadecompras.git
   cd listadecompras
   ```

2. Configure o banco de dados MySQL e execute o script SQL fornecido.

3. Compile e execute o projeto via terminal ou via IDE.

4. Para executar os testes:
   ```bash
   mvn test
   ```

---

## 🤝 Como Contribuir

1. Faça um fork deste repositório.
2. Crie uma branch com sua feature: `git checkout -b minha-feature`
3. Commit suas mudanças: `git commit -m 'feat: minha nova feature'`
4. Faça push para a branch: `git push origin minha-feature`
5. Abra um Pull Request.

---
