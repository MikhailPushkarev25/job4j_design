package ru.job4j.collection.map;

import java.util.*;

/**
 * @author Mikhail Pushkarev
 * @since 30.03.2021
 * @version 2.2
 * @param <K> - ключ
 * @param <V> - значение
 *           В классе я продемонстрировал внутренню работу методов HashMap
 */
public class SimpleHashMap<K, V> implements Maps<K, V> {
    /**
     * я создал поля - массив ключей и значений
     * инкремент size
     * инкремент modcount
     * предельную допустимую скорость работы поиска и удаления элементов из списка
     */
    private Node<K, V>[] hashTable;
    private int size;
    private int modCount;
    private static final float LOAD_FACTOR = 0.75f;
    private float thresHold;

    /**
     * конструктор
     * в конструкторе указал стандартную длину массива 16
     * далее для указания индекса массива, я умножил длину массива на скорость работы
     */
    public SimpleHashMap() {
        this.hashTable  = new Node[16];
        thresHold = hashTable.length * LOAD_FACTOR;
    }

    /**
     * метод принимает ключ
     * в методе я указал число 31
     * далее по формуле вычисляю целочисленное значение обьекта ключа
     * делю вычесленное значеное по формуле на длину массива
     * @param key - ключ
     * @return - вернуть целое число
     */
    public int hash(K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    /**
     * Метод осуществляет вставку по ключу значение
     * создаю новую ноду с ключами и значением
     * далее передаю ключ в метод  hash
     * для поиска индекса
     * далее в условии сравниваю если индекс равен нулл
     * то я в масиве зануляю ключ и значение
     * далее вытаскиваю список ноды и добавляю туда новую ноду
     * инкрементирую.
     * еще может быть такая ситуация когда место в массиве нет для этого я удвоил массив
     * создал новый массив добавил туда старый в условии сравниваю если инкремент + 1
     * больше или равно выражению которое я массив умножал на скорость работы
     * то я удваиваю значение
     * далее нужно распределить ключи и значения в новом массиве
     * я в значение записываю ноду в котрой старый массив умножил на 2
     * в цмкле пробегаюсь по старому массиву
     * если нода не равна нулю
     * то во втором цикле вытаскиваю ноды и распределяю в методе insert.
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean insert(K key, V value) {
        Node<K, V>[] oldHashTable = hashTable;
        if (size + 1 >= thresHold) {
            thresHold *= 2;
            hashTable = new Node[oldHashTable.length * 2];
            size = 0;
            for (Node<K, V> node : oldHashTable) {
                if (node != null) {
                    for (Node<K, V> n : node.getNodes()) {
                        insert(n.key, n.value);
                    }
                }
            }
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if (hashTable[index] == null) {
                hashTable[index] = new Node<>(null, null);
                hashTable[index].getNodes().add(newNode);
                size++;
                modCount++;
                return true;

        }
        return false;
    }

    /**
     * Метод удаления по ключу
     * также ключ добавляю в метод hash
     * если массив индекса равен нулл то false
     * если длина массива равна одному то индекс зануляю
     * @param key - ключ
     * @return - возвращаю результат булевой
     */
    @Override
    public boolean delete(K key) {
        int index = hash(key);
        if (hashTable[index] == null) {
            return false;
        }

        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index] = null;
            return true;
        }
        return false;
    }

    /**
     * Метод возвращает значение по ключу,
     * так же я добавляю ключ в метод hash
     * далее в условии я проверяю что индекс списка меньше массива,
     * и массив не равен нулл,
     * тогда я создаю лист с нодой, приравниваю туда массив и вытаскиваю ноды,
     * пробегаюсь по листу и сравниваю равенство ключей
     * если они равны, то возвращаю значение.
     * инкрементирую
     * @param key - ключ
     * @return - вернуть значение иначе нулл
     */
    @Override
    public V get(K key) {
        int index = hash(key);
        if (index < hashTable.length && hashTable[index] != null) {
            List<Node<K, V>> list = hashTable[index].getNodes();
            for (Node<K, V> node : list) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
                modCount++;
            }
        }
        return null;
    }

    /**
     * Счетчик
     * @return - возвращаю size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Итератор - его особенность в том что
     * я во внутреннем классе создал список и что бы по нему пройтись итератором
     * в итераторе создаю итератор списка
     * и переменные для инкремента
     * в методе hasNext - я проверяю итератор на нулл - тогда приравниваю в него
     * массив и вытаскиваю из списка ноды
     * далее в условии проверяю если при выролнении прогаммы что то изменилось то бросаю исключение
     * возвращаю итератор.
     * в методе next - я возвращаю итератор списка прохожу по нему и возвращаю значение.
     * @return
     */
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int count = 0;
            private int rsl = modCount;
            Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {
                if (subIterator == null) {
                    subIterator = hashTable[count].getNodes().iterator();
                }
                if (rsl != modCount) {
                    throw new ConcurrentModificationException();
                }
                return subIterator.hasNext();
            }

            @Override
            public V next() {

                return subIterator.next().getValue();
            }
        };
    }

    @Override
    public String toString() {
        return "SimpleHashMap{" + "hashTable=" + Arrays.toString(hashTable) + ", size=" + size + ", modCount=" + modCount + ", thresHold=" + thresHold + '}';
    }

    /**
     * Внутренний класс нод
     * @param <K> - ключ
     * @param <V> - значение
     */
    private class Node<K, V> {
        /**
         * Список в котром у нас будут ключи и значение
         * переменная hash - для вычисления индекса
         * ключ и значение - это заглушки
         */
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        @Override
        public String toString() {
            return "Node{" + "nodes=" + nodes + ", hash=" + hash + ", key=" + key + ", value=" + value + '}';
        }

        public List<Node<K, V>> getNodes() {
            return nodes;
        }

        public void setNodes(List<Node<K, V>> nodes) {
            this.nodes = nodes;
        }

        public int getHash() {
            return hash % hashTable.length;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        /**
         * В методе я проверяю на равенство обьектов,
         * очень важно генерировать правильно метод равенств для HashMap
         * @param o - обьект
         * @return - вернуть результат
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Node) {
                Node<K, V> node = (Node) o;
                return (Objects.equals(key, node.getKey()) && Objects.equals(value, node.getValue()) || Objects.equals(hash, node.getHash()));
            }
            return false;
        }

        /**
         * В методе я переопределил свой алгоритм,
         * я вставил формулу для вычисления обьекта в целочисленный тип,
         * и в методе equals - сравниваю их.
         * @return - вернуть целочисленный тип
         */
        @Override
        public int hashCode() {
            int hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }
    }

}
