package com.lab1.test2;

import com.lab1.task2.AVLTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeTest {
    private AVLTree tree;

    @BeforeEach
    void init() {
        tree = new AVLTree();
    }

    @Test
    @DisplayName("Check inserts")
    void checkInserts() {
        assertAll(
                () -> {
                    Assertions.assertArrayEquals(new int[]{5, 7, 12, 41, 56, 590}, tree.checkData(new int[]{5, 12, 590, 12, 41, 56, 7}));
                    Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, tree.checkData(new int[]{1, 2, 3, 4, 5, 6, 7}));
                    Assertions.assertArrayEquals(new int[]{1, 2, 5, 6, 19}, tree.checkData(new int[]{6, 5, 2, 1, 19}));
                    Assertions.assertArrayEquals(new int[]{2, 3, 4}, tree.checkData(new int[]{2, 4, 3}));
                }
        );
    }

    @Test
    @DisplayName("Check search")
    void checkSearch() {
        tree.insert_data(new int[]{5, 12, 590, 12, 41, 56, 7});
        assertTrue(tree.search(5));
        assertFalse(tree.search(123));
    }

    @Test
    @DisplayName("Check node count")
    void checkCountNodes() {
        tree.insert_data(new int[]{1, 2, 3, 4, 5});
        assertEquals(5, tree.countNodes());
    }


}
