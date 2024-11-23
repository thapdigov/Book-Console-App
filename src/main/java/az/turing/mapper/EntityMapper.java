package az.turing.mapper;

public interface EntityMapper<E, D> {
    E toEnt(D d);

    D toDto(E e);

    <R> R toResponse(E e);
}
