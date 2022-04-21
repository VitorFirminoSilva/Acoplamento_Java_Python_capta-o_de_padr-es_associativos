from apriori import apriori
import time

path_test = "../Arquivos/Resultados/resultado_"

path_windows = "../Arquivos/Janelamento/janela"

min_support = 0.0049
min_confidence = 0.9 
number = 11
loop = 5
for y in range(loop):
    print("Loop %d", y)
    for x in range(1, number):

        print("\nJanela" + str(x))
        transactions = []
        with open(path_windows + str(x) + ".csv", "r") as file_iter:
        #with open(path_windows + ".csv", "r") as file_iter:
            for line in file_iter:
                strA = line.strip("\n")
                tupleA = tuple(strA.split(","))
                transactions.append(tupleA)
        #print(transactions)
        inicio = time.time()
        itemsets, rules = apriori(transactions, min_support, min_confidence)
        fim = time.time()

        #for rule in rules:
            #print(rule)

        f = open(path_test + str(number) + "_sup" + str(min_support).replace('.', 'p') + "_conf" +str(min_confidence).replace('.', 'p')+ ".csv", "a")
        f.write("{}, {}, {}\n".format(("Janela" + str(x)), (len(rules)), (fim - inicio)))
        f.close()
        print("%d Regras" % (len(rules)))   
        print("Tempo de execução: %f" % (fim - inicio))

    f = open(path_test + str(number) + "_sup" + str(min_support).replace('.', 'p') + "_conf" +str(min_confidence).replace('.', 'p')+ ".csv", "a")
    f.write("\n\n")
    f.close()