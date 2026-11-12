#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
TMP=$(mktemp -d)
trap 'rm -rf "$TMP"' EXIT
javac -encoding UTF-8 -d "$TMP" Chalenges/src/{VerificadorNumeroConta,ControleSimplesDeSaques,SimulacaoBancaria,VerificacaoChequeEspecial}.java
valid=$(printf '12345678\n' | java -cp "$TMP" Chalenges.src.VerificadorNumeroConta)
[[ "$valid" == *"Número de conta válido."* ]]
invalid=$(printf 'abcd1234\n' | java -cp "$TMP" Chalenges.src.VerificadorNumeroConta)
[[ "$invalid" == *"inválido"* ]]
bank=$(printf '1\n100\n2\n-20\n3\n0\n' | java -cp "$TMP" Chalenges.src.SimulacaoBancaria)
[[ "$bank" == *"Valor invalido."* ]]
[[ "$bank" == *"Saldo atual: 100.0"* ]]
withdrawals=$(printf '100\n-20\n30\n0\n' | java -cp "$TMP" Chalenges.src.ControleSimplesDeSaques)
[[ "$withdrawals" == *"Valor invalido."* ]]
[[ "$withdrawals" == *"Limite restante: 70.0"* ]]
overdraft=$(printf '50\n-20\n' | java -cp "$TMP" VerificacaoChequeEspecial)
[[ "$overdraft" == *"Valor invalido."* ]]
echo "JAVA_ALGORITHMS_SMOKE_PASS (five cases)"
