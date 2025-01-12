package com.example.to_khai_y_te.repository;

import com.example.to_khai_y_te.entity.ToKhaiYTe;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ToKhaiRepository implements IToKhaiRepository {
    @Override
    public List<ToKhaiYTe> findAll() {
        return Collections.emptyList();
    }

    @Override
    public List<ToKhaiYTe> findAll(Sort sort) {
        return Collections.emptyList();
    }

    @Override
    public List<ToKhaiYTe> findAllById(Iterable<Long> longs) {
        return Collections.emptyList();
    }

    @Override
    public <S extends ToKhaiYTe> List<S> saveAll(Iterable<S> entities) {
        return Collections.emptyList();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ToKhaiYTe> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ToKhaiYTe> List<S> saveAllAndFlush(Iterable<S> entities) {
        return Collections.emptyList();
    }

    @Override
    public void deleteAllInBatch(Iterable<ToKhaiYTe> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ToKhaiYTe getOne(Long aLong) {
        return null;
    }

    @Override
    public ToKhaiYTe getById(Long aLong) {
        return null;
    }

    @Override
    public ToKhaiYTe getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends ToKhaiYTe> List<S> findAll(Example<S> example) {
        return Collections.emptyList();
    }

    @Override
    public <S extends ToKhaiYTe> List<S> findAll(Example<S> example, Sort sort) {
        return Collections.emptyList();
    }

    @Override
    public Page<ToKhaiYTe> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ToKhaiYTe> S save(S entity) {
        return null;
    }

    @Override
    public Optional<ToKhaiYTe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ToKhaiYTe entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ToKhaiYTe> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ToKhaiYTe> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ToKhaiYTe> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ToKhaiYTe> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ToKhaiYTe> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ToKhaiYTe, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
