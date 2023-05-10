import client from "../db.js";

const createNote = (req, res) => {
  try {
    const { note } = req.body;
    if (!note) {
      throw Error("No note present in request body");
    }

    client.query(
      "INSERT INTO notes (note) VALUES ($1)",
      [note],
      (err, data) => {
        res.status(201).json({
          error: null,
          message: "New note created",
        });
      }
    );
  } catch (error) {
    res.status(500).json({
      error: error.message,
      message: "Failed to create note",
    });
  }
};

const getNote = (req, res) => {
  try {
    client.query("SELECT * FROM notes", (err, data) => {
      if (err) throw err;

      res.status(200).json({
        err: null,
        notes: data.rows,
      });
    });
  } catch (error) {
    res.status(500).json({
      err: error.message,
      notes: null,
    });
  }
};

const getNoteById = (req, res) => {
  try {
    const { id } = req.params;

    client.query("SELECT * FROM notes WHERE id=$1", [id], (err, data) => {
      if (err) throw err;

      res.status(200).json({
        err: null,
        notes: data.rows[0],
      });
    });
  } catch (error) {
    res.status(500).json({
      err: error.message,
      notes: null,
    });
  }
};

const updateNoteById = (req, res) => {
  try {
    const { id } = req.params;
    const { note } = req.body;

    client.query(
      "UPDATE notes SET note = $1 WHERE id = $2",
      [note, id],
      (err, data) => {
        if (err) throw err;

        res.status(201).json({
          err: null,
          message: "Note updated successfully",
        });
      }
    );
  } catch (error) {
    res.status(500).json({
      err: error.message,
      message: "Note could not be updated",
    });
  }
};

const deleteNoteById = (req, res) => {
  try {
    const { id } = req.params;
    client.query("DELETE FROM notes WHERE id=$1", [id], (err, data) => {
      if (err) throw err;

      res.status(200).json({
        error: null,
        message: "Note deleted successfully",
      });
    });
  } catch (error) {
    res.status(500).json({
      err: error.message,
      message: "Note could not be deleted",
    });
  }
};

export default { getNote, createNote, getNoteById, updateNoteById, deleteNoteById };
