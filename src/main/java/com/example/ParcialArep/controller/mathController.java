package com.example.ParcialArep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class mathController {

    @GetMapping("/linearsearch")
    public SearchResponse linearSearch(@RequestParam("list") String list, @RequestParam("value") String value) {
        List<String> items = Arrays.asList(list.split(","));
        int index = linearSearch(items, value);
        return new SearchResponse("linearSearch", list, value, String.valueOf(index));
    }

    private int linearSearch(List<String> items, String value) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(value)) {
                return i; // Retornar el índice de la primera aparición
            }
        }
        return -1; // No encontrado
    }

    @GetMapping("/binarysearch")
    public SearchResponse binarySearch(@RequestParam("list") String list, @RequestParam("value") String value) {
        List<String> items = Arrays.asList(list.split(","));
        items.sort(String::compareTo); // Asegurarse de que la lista esté ordenada
        int index = binarySearchRecursive(items, value, 0, items.size() - 1);
        return new SearchResponse("binarySearch", list, value, String.valueOf(index));
    }

    private int binarySearchRecursive(List<String> items, String value, int left, int right) {
        if (left > right) return -1; // No encontrado
        int mid = left + (right - left) / 2;
        if (items.get(mid).equals(value)) return mid; // Encontrado
        if (items.get(mid).compareTo(value) > 0) {
            return binarySearchRecursive(items, value, left, mid - 1); // Buscar en la mitad izquierda
        } else {
            return binarySearchRecursive(items, value, mid + 1, right); // Buscar en la mitad derecha
        }
    }

    static class SearchResponse {
        private String operation;
        private String inputlist;
        private String value;
        private String output;

        public SearchResponse(String operation, String inputlist, String value, String output) {
            this.operation = operation;
            this.inputlist = inputlist;
            this.value = value;
            this.output = output;
        }

        public String getOperation() { return operation; }
        public String getInputlist() { return inputlist; }
        public String getValue() { return value; }
        public String getOutput() { return output; }
    }
}
